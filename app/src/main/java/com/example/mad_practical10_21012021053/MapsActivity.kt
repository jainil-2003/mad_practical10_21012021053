Package com.example.mad_practical10_21012021053import
androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.mad_practical10_21012021053.databinding.ActivityMaps2Binding
class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMaps2Binding
    private var lat:Double = 0.0
    private var log:Double = 0.0
    private var title = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaps2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val obj = intent.getSerializableExtra("Object") as Person
        //Log.i(TAG,"onCreate:Object:$obj") 
        lat = obj.latitude
        log = obj.longitude
        title = obj.name
        // Obtain the SupportMapFragment and get notified when the map is ready to be used. 
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap         val sydney = LatLng(lat,  log )
        mMap.addMarker(MarkerOptions().position(sydney).title(title))         mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
} 
