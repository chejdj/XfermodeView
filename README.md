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
<pre>
<com.example.administrator.view_designbyself.XfermodeView
       android:layout_width="200dp"
       android:layout_height="200dp"
       android:src="@drawable/test"
       android:background="@color/colorAccent"
/>
</pre>  
`background` is the Covering color, it must be defined in Color files.  
`src` is the Covered picture.  

#### Example  
![效果图](ggg)



