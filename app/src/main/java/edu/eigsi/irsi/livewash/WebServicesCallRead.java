package edu.eigsi.irsi.livewash;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniel on 18/09/2017.
 * Utilise le service Web read.php :
 * Implémenté à l'aide de
 * la librairie volley (Google)
 * <?php
 * $filename = $_POST['filename'] . '.txt';
 * $data = "";
 * // obtenir identifiant du fichier filename en lecture
 * $fileHandle = fopen ( $filename, 'r' );
 * if ($fileHandle) {
 *  // Tester si le fichier n'est pas utilisé et verrouiller l'accès
 * 	if (flock($fileHandle, LOCK_EX)) {
 * 	  // Lire une ligne du fichier et déverrouiller
 * 	  $data = fread($fileHandle, filesize($filename));
 * 	  flock($fileHandle, LOCK_UN);
 *    }
 * 	fclose($fileHandle);
 * }
 * // Retourner la donnée à l'appelant
 * echo $data;
 * ?>
 */

public class WebServicesCallRead implements  Response.Listener<String>,
        Response.ErrorListener /* facultatif */ {

  private Machine activity;
  private String url;
  private RequestQueue queue;


  /**
   * Instancifie la file de message
   * @param activity l'activité active
   * @param url l'url du fichier de lecture
   */
  public WebServicesCallRead(Machine activity, String url) {
    super();
    this.activity = activity;
    queue = Volley.newRequestQueue(activity);
    this.url = url;
  }


  /**
   * Lance la lecture du fichier du réseau
    * @param filename le fichier utilisé
   */
  public void read(final String filename) {
    StringRequest myReqWrite = new StringRequest(
        Request.Method.POST,
        url,
        this,
        null) {
      @Override
      protected Map<String, String> getParams()
          throws com.android.volley.AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("filename", filename);
        return params;
      };
    };
    // Insère la requête dans la file de messages
    queue.add(myReqWrite);
  }


  /**
   * Gère la reponse du reseau
    * @param reponse les données stockées sur le réseau
   */
  @Override
  public void onResponse(String reponse) {
    Log.d("debug", reponse);
    activity.populateRead(reponse);
  }

  /**
   * Gère les eventuelles erreurs
    * @param volleyError erreur de la bibliothèque détectée
   */
  @Override
  public void onErrorResponse(
      VolleyError volleyError) {
  }
}
