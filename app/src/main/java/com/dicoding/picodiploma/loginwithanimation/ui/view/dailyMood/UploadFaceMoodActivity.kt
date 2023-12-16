package com.dicoding.picodiploma.loginwithanimation.ui.view.dailyMood

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.dicoding.picodiploma.loginwithanimation.databinding.ActivityUploadFaceMoodBinding
import com.dicoding.picodiploma.loginwithanimation.ui.view.welcome.WelcomeActivity
import com.dicoding.picodiploma.loginwithanimation.utils.getImageUri

class UploadFaceMoodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUploadFaceMoodBinding
    private var currentImageUri: Uri? = null

    companion object {
        private const val REQUIRED_PERMISSION = android.Manifest.permission.CAMERA
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this, "Permission request granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Permission request denied", Toast.LENGTH_LONG).show()
            }
        }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            this,
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadFaceMoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_upload_face_mood)

        if (!allPermissionsGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }

        binding.cameraButton.setOnClickListener {
            startCamera()
        }
        binding.submitButton.setOnClickListener {
            startActivity(Intent(this, DailyMoodQuizActivity::class.java))
            finish()
        }
    }

    private fun startCamera() {
        currentImageUri = getImageUri(this)
        launcherIntentCamera.launch(currentImageUri)
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            showImage()
        }
    }

    private fun showImage() {
        currentImageUri?.let {
            // Log.d("Image URI", "showImage: $it")
            binding.previewImageView.setImageURI(it)
        }
    }
}