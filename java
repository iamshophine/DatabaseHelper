<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context="com.example.shophine.news.MainActivity"
    android:layout_height="match_parent"
    android:layout_width="match_parent">


    <LinearLayout

        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <ImageView
            android:layout_width="132dp"
            android:layout_height="97dp"
            android:layout_gravity="center"
            android:layout_marginTop="11dp"
            android:src="@mipmap/logo" />
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="22dp"
            android:layout_gravity="center"
            android:textSize="20dp"
            android:text="SIGN UP"/>

        <LinearLayout

            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView


                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Name"
                android:textColor="@android:color/black"
                android:layout_marginLeft="16dp"
                android:textSize="20sp" />
            <EditText
                android:id="@+id/name"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="Enter your name"
                android:layout_marginLeft="16dp"
                android:layout_marginRight="16dp" />
        </LinearLayout>


        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView


                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Reg No."
                android:textColor="@android:color/black"
                android:layout_marginLeft="16dp"
                android:textSize="20sp" />
            <EditText
                android:id="@+id/regNo"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="Register number"
                android:layout_marginLeft="16dp"
                android:layout_marginRight="16dp"
                android:inputType="number"/>
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView


                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Email"
                android:textColor="@android:color/black"
                android:layout_marginLeft="16dp"
                android:textSize="20sp" />
            <EditText
                android:id="@+id/email"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="Enter your email-id"
                android:layout_marginLeft="16dp"
                android:layout_marginRight="16dp"
                />
        </LinearLayout>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Pass"
                android:textColor="@android:color/black"
                android:layout_marginLeft="16dp"
                android:textSize="20sp" />
            <EditText
                android:id="@+id/pass"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="Password"
                android:layout_marginLeft="16dp"
                android:layout_marginRight="16dp"
                android:inputType="textPassword"/>
        </LinearLayout>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Confirm Password"
                android:textColor="@android:color/black"
                android:layout_marginLeft="16dp"
                android:textSize="20sp" />
            <EditText
                android:id="@+id/confirmPass"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="Pass Again"
                android:layout_marginLeft="16dp"
                android:layout_marginRight="16dp"
                android:inputType="textPassword"/>
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Gender     "
                android:textColor="@android:color/black"
                android:layout_marginLeft="16dp"
                android:textSize="20sp" />
            <RadioGroup
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:orientation="horizontal">
                <RadioButton
                    android:id="@+id/male"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Male" />
                    <!--android:onClick="gender"-->

                <RadioButton
                    android:id="@+id/female"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Female" />
                    <!--android:onClick="gender"-->

                <RadioButton
                    android:id="@+id/other"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Other"/>
                    <!--android:onClick="gender"-->


            </RadioGroup>

        </LinearLayout>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView

                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Mobile"
                android:textColor="@android:color/black"
                android:layout_marginLeft="16dp"
                android:textSize="20sp" />
            <EditText
                android:id="@+id/mobile"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="Contact number"
                android:layout_marginLeft="16dp"
                android:layout_marginRight="16dp"
                android:inputType="number"/>
        </LinearLayout>

        <Button
            android:id="@+id/submit"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:layout_gravity="center"
            android:onClick="confirm"
            android:text="Submit" />




    </LinearLayout>

</ScrollView>
