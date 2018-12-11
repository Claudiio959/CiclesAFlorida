package yoa.pmdm.claudio.ciclesaflorida;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TipusCicle extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private boolean mParam1;
    private boolean mParam2;
    private Button mitja;
    private  Button superior;


    private comunicaTipoCiclo mListener;

    public TipusCicle() {
        // Required empty public constructor
    }

    public static TipusCicle newInstance(boolean param1, boolean param2) {
        TipusCicle fragment = new TipusCicle();
        Bundle args = new Bundle();
        args.putBoolean(ARG_PARAM1, param1);
        args.putBoolean(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getBoolean(ARG_PARAM1);
            mParam2 = getArguments().getBoolean(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_tipus_cicle, container, false);
        mitja= v.findViewById(R.id.btnMitja);
        superior= v.findViewById(R.id.btnSup);

        if(mParam1==true)
        {
          mitja.setEnabled(true);
        }else{
            mitja.setEnabled(false);
        }

        if (mParam2)
        {
            superior.setEnabled(true);
        }
        else
        {
            superior.setEnabled(false);
        }

        return v;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof comunicaTipoCiclo) {
            mListener = (comunicaTipoCiclo) context;
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
        if (v.getId()==mitja.getId())
        {
            mListener.tipoCicloPulsado(1);
        }
        else if(v.getId()==superior.getId())
        {
            mListener.tipoCicloPulsado(2);
        }
    }

    public interface comunicaTipoCiclo {
        // TODO: Update argument type and name
        void tipoCicloPulsado(int id);
    }
}
