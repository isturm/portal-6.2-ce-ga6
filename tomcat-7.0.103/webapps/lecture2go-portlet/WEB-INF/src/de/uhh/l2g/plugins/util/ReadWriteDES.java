package de.uhh.l2g.plugins.util;

/***************************************************************************
 * The Lecture2Go software is based on the liferay portal 6.1.1 
 * <http://www.liferay.com>
 * 
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source 
 * platform for media management and distribution. Our goal is to 
 * support the free access to knowledge because this is a component 
 * of each democratic society. The open source software is aimed at 
 * academic institutions and has to strengthen the blended learning.
 * 
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 * 
 * @Autor Lecture2Go Team
 * @Version 1.0
 * @Contact lecture2go-open-source@uni-hamburg.de
 *  
 * Copyright (c) 2013 University of Hamburg / Computer and Data Center (RRZ)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 ***************************************************************************/
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

/**
 * The Class ReadWriteDES.
 */
public class ReadWriteDES {

	/**
	 * Encode.
	 *
	 * @param bytes the bytes
	 * @param out the out
	 * @param pass the pass
	 * @throws Exception the exception
	 */
	static void encode(byte[] bytes, OutputStream out, String pass) throws Exception {
		Cipher c = Cipher.getInstance("DES");
		Key k = new SecretKeySpec(pass.getBytes(), "DES");
		c.init(Cipher.ENCRYPT_MODE, k);

		OutputStream cos = new CipherOutputStream(out, c);
		cos.write(bytes);
		cos.close();
	}

	/**
	 * Decode.
	 *
	 * @param is the is
	 * @param pass the pass
	 * @return the byte[]
	 * @throws Exception the exception
	 */
	static byte[] decode(InputStream is, String pass) throws Exception {
		Cipher c = Cipher.getInstance("DES");
		Key k = new SecretKeySpec(pass.getBytes(), "DES");
		c.init(Cipher.DECRYPT_MODE, k);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		CipherInputStream cis = new CipherInputStream(is, c);

		for (int b; (b = cis.read()) != -1;)
			bos.write(b);

		cis.close();
		return bos.toByteArray();
	}
}
