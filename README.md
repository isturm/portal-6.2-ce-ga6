#  Lecture2Go Video Portal

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

## 4. Streaming server 

## 4.1. Linking Lecture2Go with Streaming Server

## 5. Download server
