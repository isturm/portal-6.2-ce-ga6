package de.uhh.l2g.plugins.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import de.uhh.l2g.plugins.NoSuchAutocompleteException;
import de.uhh.l2g.plugins.guest.OpenAccessVideos;
import de.uhh.l2g.plugins.model.Autocomplete;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.AutocompleteLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;


public class AutocompleteManager {
	/** The dao bean factory. */
	private XmlBeanFactory daoBeanFactory; 
	
	public void setDaoBeanFactory(XmlBeanFactory daoBeanFactory) {
		this.daoBeanFactory = daoBeanFactory;
	}
	
	public XmlBeanFactory getDaoBeanFactory() {
		return daoBeanFactory;
	}
	
	public List<String> getAllVideos() {
		
		List<String> resultList = new ArrayList<String>();
		List<Video> videoList = new ArrayList<Video>();

		try {
			videoList = VideoLocalServiceUtil.getAll();
		} catch (SystemException e) {
			////e.printStackTrace();
		}
				
		for (Video video : videoList) resultList.add(video.getTitle());
		return resultList;
	}
	
	
	public static synchronized List<String> getAutocompleteResults() throws SystemException {
		List<String> resultList = new ArrayList<String>();
		List<Video> videoList = new ArrayList<Video>();	
		if (videoList.size() == 0) videoList = VideoLocalServiceUtil.getByAllSearchWords();
		for (Video video : videoList) {
			/** Return only the string, that contained the search term */
			String title = video.getTitle().trim();
			String series = video.getLectureseriesName().trim();
			String[] carr = video.getCreators().split("###");
			String tags = video.getTags().trim();

			if (!isDuplicate(resultList, title)) resultList.add(title);
			if (!isDuplicate(resultList, series)) resultList.add(series);
			for(int i = 0; i<carr.length; i++){
				if (!isDuplicate(resultList, carr[i])) resultList.add(carr[i]);
			}
			if (!isDuplicate(resultList, tags)) resultList.add(tags);

			/**
			 * Limit the number of result strings for ajax request to 10 if
			 * (resultList.size() >= 10) { break; }
			 */

		}
		return resultList;
	}
	
	public static synchronized boolean generateAutocompleteResults() throws SystemException  {
		OpenAccessVideos.wordsJSONArray = JSONFactoryUtil.createJSONArray();
		List<String> arrStr = new ArrayList<String>();
		JSONObject strJSON = null;
		arrStr = getAutocompleteResults();
		for (String str : arrStr) {
			strJSON = JSONFactoryUtil.createJSONObject();
			strJSON.put("word", str);
			OpenAccessVideos.wordsJSONArray.put(strJSON);
			//System.out.println(str);
		}
		
		try {
			// update autocomplete record
			Autocomplete autocomplete = AutocompleteLocalServiceUtil.getSingularAutocomplete();
			autocomplete.setSearchWordsJson(OpenAccessVideos.wordsJSONArray.toString());
			AutocompleteLocalServiceUtil.updateAutocomplete(autocomplete);
		} catch (NoSuchAutocompleteException e) {
			// no autocomplete record, this happens on a new setup, create one
			Autocomplete autocomplete = AutocompleteLocalServiceUtil.createAutocomplete(0);
			autocomplete.setSearchWordsJson(OpenAccessVideos.wordsJSONArray.toString());
			AutocompleteLocalServiceUtil.addAutocomplete(autocomplete);
		}
		return true;
	}
	
	private static boolean isDuplicate(List<String> resultList, String word){
		boolean ret = false;
		for(String w : resultList){
			w=w.trim();
			if(w.equals(word)) ret=true;
		}
		return ret;
	}

}
