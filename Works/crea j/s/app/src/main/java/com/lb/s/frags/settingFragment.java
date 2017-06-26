package com.lb.s.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.lb.s.R;
import com.lb.s.conec.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by HP on 20/6/2017.
 */

public class settingFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup con,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.setting_fragment, con, false);

        create(v);
        return v;
    }
    public void create(View v) {
        Button btn1 = v.findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getContext(), "Toast1", Toast.LENGTH_SHORT).show();
                cargarAdaptador();
                //man Trans = new man();
                //Trans.execute(getContext());
            }
        });
        Button btn2 = v.findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getContext(), "Toast2", Toast.LENGTH_SHORT).show();
                //Transferencia Trans = new Transferencia();
                //Trans.execute(email, fname, lname, uname, paswd);
            }
        });
    }
    public void cargarAdaptador() {
        // Petición GET
        VolleySingleton.
                getInstance(getActivity()).
                addToRequestQueue(
                        new JsonObjectRequest(
                                Request.Method.GET,
                                "http://192.168.1.3/sivar/man.php",
                                null,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        Log.d("Volley: ","-> Ok 200");
                                        // Procesar la respuesta Json
                                        procesarRespuesta(response);
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Log.d("Error Volley: ","-> " + error.getMessage());
                                    }
                                }

                        )
                );
    }
    private void procesarRespuesta(JSONObject response) {
        try {
            // Obtener atributo "estado"
            String estado = response.getString("estado");

            switch (estado) {
                case "1": // EXITO
                    // Obtener array "metas" Json
                    JSONArray mensaje = response.getJSONArray("datos");
                    Toast.makeText(getActivity(),mensaje.toString(),Toast.LENGTH_LONG).show();
                    //Log.i("procesarRespuesta:",mensaje.toString());
                    // Parsear con Gson
                    //Meta[] metas = gson.fromJson(mensaje.toString(), Meta[].class);
                    // Inicializar adaptador
                    //adapter = new MetaAdapter(Arrays.asList(metas), getActivity());
                    // Setear adaptador a la lista
                    //lista.setAdapter(adapter);
                    break;
                case "2": // FALLIDO
                    String mensaje2 = response.getString("mensaje");
                    Toast.makeText(
                            getActivity(),
                            mensaje2,
                            Toast.LENGTH_LONG).show();
                    break;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

