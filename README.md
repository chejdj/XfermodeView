## How to use it
**gradle**  
#### Step1   
Add it in your root build.gradle at the end of repositories:  
<pre>
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
</pre>  

#### Step2  
Add the dependency
<pre>
dependencies {
	        compile 'com.github.chejdj:XfermodeView:1.0'
}
</pre>  

#### usages
in your Activitity  
```
<com.example.administrator.view_designbyself.XfermodeView
       android:layout_width="200dp"
       android:layout_height="200dp"
       android:src="@drawable/test"
       android:background="@color/colorAccent"
/>
```  
background is the Covering color, it must be defined in colors.xml file.  
src is the Covered picture.  

#### Example  
![效果图](https://github.com/chejdj/XfermodeView/blob/master/images/01.png)



