#  Lecture2Go Video Portal Installation Guide

The [media and distribution portal](https://lecture2go.uni-hamburg.de) software of the University of Hamburg is now available for other institutions of education in an open source version. The software is currently in further development for Liferay Version 6.2.

Watch our official [project video](https://lecture2go.uni-hamburg.de/l2go/-/get/v/15934) (German).

# The media distribution platform "to take away"

The Lecture2Go media distribution portal software is based on Liferay (liferay.com). All plugins for our software are being developed at the Regional Computer Center (RRZ) at the University of Hamburg.

Lecture2Go supports the free access to knowledge because this is a component of each democratic society. The open source software is aimed at academic institutions and its objective is to strengthen the blended learning.

# Installation (Linux, MAC)
Lecture2Go runs on Linux and Mac systems. The required hardware is depending on the usage of the portal. The following configuration has been implemented at the University  of Hamburg since year 2010.

## 1. System requirements
    Web server
        Operating system - SUSE 11 (x86_64)
        CPU – 16 x Intel(R) Xeon(R) E5640 @ 2.67 GHz
        RAM – 8 GB
        Hard drive – 500 GB
    Streaming server
        Operating system - SUSE 11 (x86_64)
        CPU – 8 x Intel(R) Xeon(R) E5430 @ 2.66 GHz
        RAM – 8 GB
        Hard drive – 4 TB. With this capacity, a large amount of videos are hosted. If a ninety minute 
        lecture recording does not exceed the data volume of 600 MB, so 4TB of storage would be sufficient 
        for about 6500 videos. LAN – 1Gb. With this bandwidth and average transmission of 500 Kb/sec bit rate 
        can be realized around 2000 simultaneous streams.
    Download server
        Operating system - SUSE 11 (x86_64)
        CPU – 16 x Intel(R) Xeon(R) E5640 @ 2.67 GHz
        RAM – 8 GB
        Hard drive – 500 GB
        LAN – 1 Gb

## 2. Database server
For this setup we will use a MySQL database. At this point we do not provide any installation instructions for MySQL because you can find very good guides on the official website of MySQL as well as on numerous other websites.

After setting up the server create a user account which will be used to access the MySQL server. These login parameters will be required in section 3 - username (dbuser) and password (dbpassword).

There are various administration tools for MySQL database servers. We recommend the official MySQL administration tools, which are downloadable from the software manufacturer's website.

## 3. Portal server
You have to be a root user for this setup! Create the directory /usr/local/l2go (chmod 755 /usr/local/l2go for Mac) and then unpack the downloaded file portal-6.2-ce-ga6-master.zip into it and rename the unpacked directory to portal-6.2-ce-ga6. The unzipped file /usr/local/l2go/portal-6.2-ce-ga6/install.sql contains all necessary tables and settings to integrate the Lecture2Go plugins in Liferay 6.2.

Import install.sql onto the installed MySQL database server.

Afterwards the portal software can be prepared for further installation. First edit the configuration file portal-setup-wizard.properties, which can be found under:

    your-lecture2go-server:~ # cd /usr/local/l2go/portal-6.2-ce-ga6/
    your-lecture2go-server:/.../portal-6.2-ce-ga6/ # joe portal-setup-wizard.properties
Here you enter the installation directory:
 
    liferay.home=/usr/local/l2go/portal-6.2-ce-ga6
 

Now edit the configuration file portal-ext.properties:

    your-lecture2go-server:~ # cd /usr/local/l2go/portal-6.2-ce-ga6/tomcat-7.0.62/webapps/
    your-lecture2go-server:/.../webapps/ # joe ROOT/WEB-INF/classes/portal-ext.properties

Configure the database access by modifying the following lines in the 'Database Properties':

    ############ Database Properties ############
    jdbc.default.driverClassName=com.mysql.jdbc.Driver
    jdbc.default.url=jdbc:mysql://my-mysql-server.com/lportal?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false
    jdbc.default.username=dbuser
    jdbc.default.password=dbpassword

    jdbc.default.url – Replace "mysql.server.com" with the URL of your databank server.
    jdbc.default.username – Enter your user name.
    jdbc.default.password – Enter your databank password.

In the section 'Lecture2Go Properties', adjust the following parameters:

    ############ Lecture2Go Properties ############
    lecture2go.web.root=http://my-webserver.de
    lecture2go.web.home=${lecture2go.web.root}
    lecture2go.downloadserver.root=http://my-downloadserver.de
    lecture2go.media.repository=/l2gomedia
    lecture2go.images.system.path=${lecture2go.media.repository}/images
    lecture2go.httpstreaming.video.repository=${lecture2go.media.repository}/vh_000
    lecture2go.security.folder=/security
    lecture2go.ffmpeg.bin=/usr/local/bin/ffmpeg
    lecture2go.shell.bin=/bin/bash
    lecture2go.response.email.address=lecture2go@l2go.edu
    lecture2go.noresponse.email.address=noresponse@l2go.edu

The most important settings for the installation of the plug-ins are provided with the prefix lecture2go.* .

- lecture2go.web.root – Enter the URL of your Lecture2Go server (If necessary enter portnumber, e.g. http://mywebserver.de:8080).
- lecture2go.web.home – This parameter must not be changed.
- lecture2go.downloadserver.root – For load balancing we recommend to use a separate the download server from the web server. 
- Then enter here the URL of this server. Otherwise enter 'lecture2go.downloadserver.root=${lecture2go.web.root}'
- lecture2go.media.repository – Enter the file path where the uploaded video content should be stored. 
- The default parameter is /l2gomedia.
- lecture2go.response.email.address – E-Mail adress from the system administrator
- lecture2go.noresponse.email.address – Autoresponder e-mail adress

The following parameters should not be changed!

- lecture2go.images.system.path – All produced images are stored in this directory.
- lecture2go.httpstreaming.video.repository – This is a very important directory, because the streaming server accesses it for delivering the media content via HTTP streaming.
- lecture2go.security.folder – location for all .htaccess protection files.

In order to change the last two parameters run the following commands:

    your-lecture2go-server:~ # which ffmpeg
    /usr/local/bin/ffmpeg

    lecture2go.ffmpeg.bin = /usr/local/bin/ffmpeg

If the FFMPEG-library is not installed on your Linux system, you have to install it.

    your-lecture2go-server:~ # which bash
    /bin/bash

    lecture2go.shell.bin = /bin/bash

After the configuration file has been filled with the necessary parameters and the MySQL server is available, you can start the portal. Proceed as follows:

    your-lecture2go-server:~ # cd /usr/local/l2go/portal-6.2-ce-ga6/tomcat-7.0.62/bin/
    your-lecture2go-server:/usr/local/l2go/portal-6.2-ce-ga6/tomcat-7.0.62/bin # chmod 755 *
    your-lecture2go-server:/usr/local/l2go/portal-6.2-ce-ga6/tomcat-7.0.62/bin # ./startup.sh

Assuming you have made all necessary preparations, the portal software will be launched successfully.
 
The server logs can be found under /usr/local/l2go/portal-6.1.1-ce-ga2/tomcat-7.0.62/logs. The starting process will finish with a similar log output:

    your-lecture2go-server:~ # tail -f /usr/local/l2go/portal-6.1.1-ce-ga2/tomcat-7.0.62/logs/catalina.out

    INFO: Starting Coyote HTTP/1.1 on http-80
    Jul 25, 2012 12:46:01 PM org.apache.jk.common.ChannelSocket init
    INFO: JK: ajp13 listening on /0.0.0.0:8009
    Jul 25, 2012 12:46:01 PM org.apache.jk.server.JkMain start
    INFO: Jk running ID=0 time=0/177  config=null
    Jul 25, 2012 12:46:03 PM org.apache.catalina.startup.Catalina start
    INFO: Server startup in 40776 ms
    12:46:49,528 INFO  [PluginPackageUtil:1148] Reloading repositories

## 4. Streaming server 
The default installation of this video portal suppors HTML5 streaming! The streaming server is an optional component. At this point it is important to mention that due to better load distribution the server should be installed on a separate machine.

Hereinafter is offered a quick start guide for the installation.

First download the latest version of Wowza:

    your-lecture2go-streamer:~ #  wget http://www.wowza.com/downloads/WowzaStreamingEngine-4-0-0/WowzaStreamingEngine-4.0.0.tar.bin

Execute the following commands:

    your-lecture2go-streamer:~ #  sudo chmod +x WowzaStreamingEngine-4.0.0.tar.bin
    your-lecture2go-streamer:~ #  sudo ./WowzaStreamingEngine-4.0.0.tar.bin

After installing the license key must be entered. You can get a free trial license of the Wowza software. With this trial license all features of the server are usuable and up to ten simultaneous streams can be supported.

After the software is registered, you can proceed with the configuration (Section 4.1).

## 4.1. Linking Lecture2Go with Streaming Server
After setting up the streaming server it must be linked to the Lecture2Go media repository (location of all media files). So that the uploaded video contents can be found by the streaming server, some settings must be adjusted in the /usr/local/WowzaStreamingEngine/conf.

- VHost.xml – This is where you configure the port number of your server. Change the port number to 80 (approx line 10), because the server must be accessible via the HTTP protocol.
    --```<!-- 80: HTTP, RTMPT -->
        <!-- 554: RTSP -->
        <Port>80</Port>```
- Application.xml – The media repository, which the server accesses, can be configurated in this file.
--```
    <Streams>
    <StreamType>default</StreamType>
    <StorageDir>${com.wowza.wms.context.VHostConfigHome}/content</StorageDir>```
The media repository of your server is defined in node <StorageDir> </ StorageDir>. We do not recommend to change this default value but to replace the directory ${com.wowza.wms.context.VHostConfigHome}/content with a symbolic link to your Lecture2Go media repository. In Section 3 we already set the parameter lecture2go.httpstreaming.video.repository. The value of this parameter (/l2gomedia/vh_000/) is your Lecture2Go media repository and is now needed for linking the two components.

Perform the following:

    your-lecture2go-streamer:~ #  cd /usr/local/WowzaStreamingEngine
    your-lecture2go-streamer:/usr/local/WowzaStreamingEngine # rm –r content
    your-lecture2go-streamer:/usr/local/WowzaStreamingEngine # ln -s /l2gomedia/vh_000/ content

As a final step, the server must be registered in your Lecture2Go portal. Therefore login as Lecture2Go administrator. Now find the menu "My L2Go" -> "Streaming server". Streaming servers can be registered or edited here.

## 5. Download server
