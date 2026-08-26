# Add project specific R8 rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   https://d.android.com/studio/build/shrink-code

# Simple Compose project: no custom keep rules required.
# AndroidX Compose, Material3, Activity and Core KTX ship with
# consumer keep rules that R8 applies automatically.
# Add rules below only if you use reflection, serialization, JNI or WebView JS.

# Example: keep WebView JS interface
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Keep line numbers for crash stack traces (uncomment to enable)
# -keepattributes SourceFile,LineNumberTable
# -renamesourcefileattribute SourceFile