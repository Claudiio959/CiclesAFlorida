package yoa.pmdm.claudio.ciclesaflorida;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class Llistat extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView mensaje;

    // TODO: Rename and change types of parameters
    private int mParam1;
    private ArrayList<Ciclo> mParam2;

    private OnFragmentInteractionListener mListener;

    public Llistat() {
        // Required empty public constructor
    }

    public static Llistat newInstance(int param1, ArrayList<Ciclo>param2) {
        Llistat fragment = new Llistat();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putParcelableArrayList(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getParcelableArrayList(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_llistat, container, false);
        mensaje= v.findViewById(R.id.txtMensaje);
        Leer();

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void Leer(){
        mensaje.setText("");
        Log.d("MIO", "Antes For");

        if (mParam2!=null)
        {
            for(int i=0;i<mParam2.size();i++) {
                if (mParam1==1 && mParam2.get(i).getTipus()=="Mitjà")
                {
                    mensaje.setText(mensaje.getText()+mParam2.get(i).toString()+"\n"+"\n");
                }
                else if(mParam1==2 && mParam2.get(i).getTipus()=="Superior")
                {
                    mensaje.setText(mensaje.getText()+mParam2.get(i).toString()+"\n"+"\n");
                }
            }
        }
        else
        {
            Log.d("MIO","Era null");
        }
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
