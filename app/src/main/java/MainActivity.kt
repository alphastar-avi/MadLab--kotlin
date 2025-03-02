import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical">

<!-- Student Details Fragment -->
<androidx.fragment.app.FragmentContainerView
android:id="@+id/fragment_details"
android:name="StudentDetailsFragment"
android:layout_width="match_parent"
android:layout_height="wrap_content" />

<!-- Student Marks Fragment -->
<androidx.fragment.app.FragmentContainerView
android:id="@+id/fragment_marks"
android:name="com.example.studentapp.StudentMarksFragment"
android:layout_width="match_parent"
android:layout_height="wrap_content" />
</LinearLayout>
class StudentDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student_details, container, false)
    }
}