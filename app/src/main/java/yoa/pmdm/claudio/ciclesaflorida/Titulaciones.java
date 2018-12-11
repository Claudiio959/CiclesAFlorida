package yoa.pmdm.claudio.ciclesaflorida;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Titulaciones extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button empresa;
    private Button esports;
    private Button informatica;

    private comunicaTitulacion mListener;

    public Titulaciones() {

    }

    public static Titulaciones newInstance(String param1, String param2) {
        Titulaciones fragment = new Titulaciones();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_titulaciones, container, false);

        empresa = (Button) v.findViewById(R.id.empresa);
        esports = (Button) v.findViewById(R.id.esports);
        informatica = (Button) v.findViewById(R.id.informatica);
        empresa.setOnClickListener(this);
        esports.setOnClickListener(this);
        informatica.setOnClickListener(this);

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof comunicaTitulacion) {
            mListener = (comunicaTitulacion) context;
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

    @Override
    public void onClick(View v) {
        if (v.getId()==empresa.getId())
        {
            mListener.titulacionPulsada(1);
        }
        else if (v.getId()==esports.getId())
        {
            mListener.titulacionPulsada(2);
        }
        else if (v.getId()==informatica.getId())
        {
            mListener.titulacionPulsada(3);
        }
    }


    public interface comunicaTitulacion {
        // TODO: Update argument type and name
        void titulacionPulsada(int id);
    }
}
