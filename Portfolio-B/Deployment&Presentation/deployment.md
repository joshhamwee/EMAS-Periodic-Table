# Installation Process
## For PC
Since it is normally not possible to run a Android app on your PC, we will first have to download
an emulator that will allow us to run the app. The emulator that we are going to be using is Bluestacks, which can be found [here](https://www.bluestacks.com/). Follow the instructions provided by the installer to install the emulator.

1. After Bluestack is installed, open it and sign in to the Google Play Store.
2. In the search bar, type `EMAS Periodic Table`, or click the link [here](https://play.google.com/store/apps/details?id=com.pta.joshhamwee.periodictablemain&hl=en_GB)
3. Install the app by clicking the `Install` button and following the instructions on the screen

## For Android
On an Android device, it is possible to directly install the app from the Google Play Store. Your Android device needs to have Android version 4.1 or above to install the app.

1. Open the Play Store and sign in if you haven't already
2. In the search bar, type `EMAS Periodic Table`, or click the link [here](https://play.google.com/store/apps/details?id=com.pta.joshhamwee.periodictablemain&hl=en_GB)
3. Install the app by clicking the `Install` button and following the instructions on the screen

# Deployment Process
## Building the APK
After changes have been made to the app, there are a few steps before you can build the APK for the app and upload it to the Play Store.

1. In Android Studio, under Gradle Scripts, open `build.gradle` for the module
2. Under `defaultConfig`, there should be two variables `versionCode` and `versionName`
3. While it is not important to update `versionName`, it is imperative to increment the value of `versionCode`

Now that the above steps have been completed, we need to build the APK.

1. Under `Build`, click on the option `Generate Signed Bundle / APK...`
2. Select the APK option and follow the steps shown
3. For the `Key store path`, locate the `test.jks` file saved on your computer and use that to sign the APK produced.
4. Input the password provided to allow the key to be used.
5. After clicking `Next`, set the destination for the APK to be saved, select the `Build Type` as `release` and tick both check boxes under `Signature Versions` to sign the app with both `V1 (Jar Signature)` and `V2 (Full APK Signature)`

## Deploying the APK to the Play Store
Now that the APK has been built and signed, we need to upload the new APK to the Play Store to push the update.

1. Go the the Play Console and sign in to the account
2. Under `All applications`, select the `EMAS Periodic Table`
3. Click on `Release management` and select `App releases`
4. Since we are releasing the app to the public, click `Manage` under the `Production Track` and click `Create Release`
5. Under `Android App Bundles and APKs to add`, browse for your APK and upload it
6. Under `What's new in this release?`, enter the changes made for this version of the app, and click `Save`
7. Next click `Review`, and follow click `Start Rollout` to deploy the app to the Play Store
