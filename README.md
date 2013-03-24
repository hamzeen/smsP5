## smsP5 ##
A processing library to send and recieve short messages (SMS).

This library wraps around SMSLib to provide a simple API for Processing users to send and receive 
short messages from Processing. Below is a screen from one of the examples which comes 
as part of the library.

![alt text](https://github.com/hamzeen/smsP5/raw/master/receive_screen.jpg "A screen from an example")

## Installation ##
The instalaltion of this library follows the same process of extracting the archive you obtain here to your 
libraries folder, found inside your sketchbook folder/directory. It should be similar to the installation of 
any other P5 library. Since, these are essentially wrapper classes around SMSLib, you need to install JavaCOMM 
unless, it is already installed.

### Java COMM Installation ( files inside *extras* )
*   File comm.jar should be copied to JDK_DIR/jre/lib/ext/ (typically, JDK_DIR=C:\Program Files\Java)
*   File javax.comm.properties should be copied to JDKDIR/jre/lib/
*   Library files (i.e. win32com.dll for Win32 or the .so Linux library files) should be copied to JDKDIR/jre/bin/
*   If you have more JRE installations, please follow the same with each installation. This is important!
*   The extras folder here, only contains files required for installation on Windows boxes running on 32-bit (i586) Java.
*   However, this library should work on all platforms. Hence if you are not on a Windows box, 
please follow installation instructions tailored for your OS/distribution at, [SMSLib Installation] (http://smslib.org/doc/installation/).
*   **Known Issue**: This might not work with 64-bit Java installations and it's a known issue with SMSLib as well. 
Hence in this case, I reccoment you to install 32-bit Java.

## Examples & Usage ##
The libray contains two seperate examples on sending and receiving short messages (SMS) using the library. 
When you run these examples, roughly it takes around half a minute to actually start sending or receiving 
messages. However SMSLib is know to be little slow to start with. Hence, it requires some patience to 
work with it. When you are ready to use this library as part of your sketch, please make sure to have 
a copy of log4j.properties file found inside both examples along side your source files (.pde). Also 
when you package, make it a point to copy the same (log4j.properties) to where your executable reside.

## Credit ##
*   [**SMSLib**] (http://smslib.org/), for making this library possible.

## LICENSE ##
Copyright © 2013 Hamzeen. H.
Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0

Permission is hereby granted, free of charge, to any person
obtaining a copy of this project. It includes the rights to use,
fork, modify, merge, publish and distribute.

THE SOURCE OF THIS PROJECT IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND.
