package edu.eigsi.irsi.livewash;

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
 * Utilise le service Web write
 * Implémenté à l'aide de
 * la librairie volley (Google)
 * <?php
 * // Récuperer le nom du fichier
 * $filename = $_POST['filename'];
 * // Récupérer la donnée
 * $data  = $_POST['data'];
 * // Memoriser data un fichier filename.txt
 * $status = 'NO_OK';
 * $fileHandle = fopen ( $filename . '.txt', 'w' );
 * if ($fileHandle) {
 * 	if (flock($fileHandle, LOCK_EX)) {
 * 			fwrite($fileHandle, $data);
 * 			flock($fileHandle, LOCK_UN);
 * 			$status = 'OK';
 *    }
 *     fclose($fileHandle);
 * }
 * echo $status;
 * ?>
 *
 */

public class WebServicesCallWrite implements  Response.Listener<String>,
        Response.ErrorListener /* facultatif */ {
  private Machine activity;
  private String url;
  private RequestQueue queue;

  /**
   * Instancifie la file de message
   * @param activity l'activité active
   * @param url l'url du fichier d'écriture
   */
  public WebServicesCallWrite(Machine activity, String url) {
    super();
    this.activity = activity;
    // Instancie la file de message (cet objet doit être un singleton)
    queue = Volley.newRequestQueue(activity);
    this.url = url;

  }

  /**
   * Lance l'écriture du fichier du réseau
   * @param filename le fichier utilisé
   */
  public void write(final String filename, final String data) {
    StringRequest myReqWrite = new StringRequest(
        Request.Method.POST, url, this, null) {
      @Override
      protected Map<String, String> getParams()
          throws com.android.volley.AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("filename", filename);
        params.put("data", data);
        return params;
      };
    };
    // Insère la requête dans la file de messages
    queue.add(myReqWrite);
  }

  /**
   * Gère la réponse du réseau
   * @param reponse les données stockées sur le réseau
   */
  @Override
  public void onResponse(String reponse) {
    Log.d("debug", reponse);
    activity.populateWrite(reponse);
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
