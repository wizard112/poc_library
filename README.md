# poc_library
A create a mini library in Kotlin to facilate the manipulation of permissions and files.
You can ask permissions to get photo
You can write a file in any storage internal or external
You can get a string format for the current date or a specific date

Get started

Prerequisites
/

Installation

  Add in your Gradle
  compile ''
  
  Code
  
  to ask permission don't forget to add it in manifest before. For example camera
  1. add in Manifest
     <uses-permission android:name="android.permission.CAMERA" />
  2. From activity or Fragment you can call
     AskPermissions.checkPermissionCamera(this)
