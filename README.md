## smsP5 ##
A processing library to send/recieve short messages (SMS). This library wraps around SMSLib to 
provide a simple API for Processing users. It was tested to work on both 1.5.1 as well as the latest 2.0 versions of Processing. Below is a screen from one of the examples which comes as part of the library.

![alt text](https://github.com/hamzeen/smsP5/raw/master/receive_screen.jpg "A screen from an example")

## Installation ##
### For Processing versions earlier than 2.0
The instalaltion of this library follows the same process of extracting the archive you obtain here to your 
libraries folder, found inside your sketchbook folder. 

### For Processing 2.0
You can navigate to Tools-> Add Tool... and select smsP5.

### Java COMM Installation

After the instalaltion of the library you also need to install JavaCOMM as this library is 
essentially a set of wrappers around SMSLib. Installation instructions for it can be found below, all the required files for it can be found inside *extras* folder of the library.

*   File comm.jar should be copied to JDK_DIR/jre/lib/ext/ (typically, JDK_DIR=C:\Program Files\Java)
*   File javax.comm.properties should be copied to JDKDIR/jre/lib/
*   Library files (i.e. win32com.dll for Win32 or the .so Linux library files) should be copied to JDKDIR/jre/bin/
*   If you have more JRE installations, please follow the same with each installation. This is important!
*   The extras folder here, only contains files required for installation on Windows boxes running on 32-bit (i586) Java.
*   However, this library should work on all platforms. Hence if you are not on a Windows box, 
please follow installation instructions tailored for your OS/distribution at, [SMSLib Installation] (http://smslib.org/doc/installation/).
*   For PROCESSING 2.0: The file, javax.comm.properties also needs to be copied to /processing-2.0/java/lib/ it's an additioanl step for you.
*   **Known Issue**: This might not work with 64-bit Java installations and it's a known issue with SMSLib as well. 
Hence in this case, I reccoment you to install 32-bit Java.

## Examples & Usage ##
The libray contains two seperate examples on sending/receiving short messages (SMS) with the library. When you 
run these examples for the first time, it might be little slow. So please be patient untill it gets underway. Once you export an application which uses this library, it will take care of everything it requires to make sure that is works on any machine without requiring the JavaCOMM installation as above. Enjoy!

## Credit ##
*   [**SMSLib**] (http://smslib.org/), for making this library possible.

## LICENSE ##
Copyright © 2013 Hamzeen. H.
Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0

Permission is hereby granted, free of charge, to any person
obtaining a copy of this project. It includes the rights to use,
fork, modify, merge, publish and distribute.

THE SOURCE OF THIS PROJECT IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND.
