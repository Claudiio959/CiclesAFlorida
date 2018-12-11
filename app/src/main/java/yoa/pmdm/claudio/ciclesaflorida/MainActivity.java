package yoa.pmdm.claudio.ciclesaflorida;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TipusCicle.comunicaTipoCiclo,Titulaciones.comunicaTitulacion, Llistat.OnFragmentInteractionListener{
    FragmentManager fm;
    FragmentTransaction ft;
    Titulaciones fragmentArriba;
    Fragment fragmentCentro;
    Fragment fragmentAbajo;

    ArrayList <Ciclo> arrayCiclos;
    ArrayList <Ciclo> arrayAux;
    boolean btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayCiclos = new ArrayList<Ciclo>();
        btn1 = false;
        btn2 = false;
        fm = getSupportFragmentManager();
        fragmentCentro = TipusCicle.newInstance(btn1,btn2);
        fragmentAbajo = Llistat.newInstance("","");
        fragmentArriba = (Titulaciones) fm.findFragmentById(R.id.fragment);

        ft= fm.beginTransaction();

        ft.add(R.id.fmedio,fragmentCentro);
        ft.add(R.id.fabajo,fragmentAbajo);

        ft.commit();

        creaDades();
    }

    @Override
    public void tipoCicloPulsado(int id) {

    }

    @Override
    public void titulacionPulsada(int id) {
        recorrerArray(id);
        ft= fm.beginTransaction();

        Fragment auxFrag = TipusCicle.newInstance(btn1,btn2);
        ft.add(R.id.fmedio,auxFrag);

        ft.commit();
        btn1 = false;
        btn2 = false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void creaDades(){
        Ciclo c;

        c = new Ciclo("ESPORT","Superior","Animació d'activitats físiques i esportives","Aquesta formació concertat de nivell superior cicle formes com un Tècnic Superior en activitats físiques i esportives, que està especialitzat en ensenyament i dinamització de jocs i activitats de fitness.");
        arrayCiclos.add(c);
        c = new Ciclo("ESPORT","Mitjà","Conducción de actividades físico deportivas en el medio natural","Este Ciclo Formativo de Grado Medio te forma como Técnico/a en Conducción de actividades físico deportivas en el medio natural, permitiéndote la especialización posterior como Técnico de Actividades físico deportivas.");
        arrayCiclos.add(c);
        c = new Ciclo("EMPRESA","Superior","Gestión de Ventas y Espacios Comerciales","Nuevo ciclo formativo de grado superior concertado por la GVA");
        arrayCiclos.add(c);
        c = new Ciclo("EMPRESA","Superior","Marketing y publicidad","Este ciclo te prepara para definir y efectuar el seguimiento de las políticas de marketing de una empresa.");
        arrayCiclos.add(c);
        c = new Ciclo("EMPRESA","Superior","Administración y Finanzas / FP Dual BANKIA","Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        arrayCiclos.add(c);
        c = new Ciclo("INFORMÀTICA","Mitjà","Sistemas Microinformáticos y Redes","Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        arrayCiclos.add(c);
        c = new Ciclo("INFORMÀTICA","Superior","Administración de Sistemas Informáticos y en Red","Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        arrayCiclos.add(c);
        c = new Ciclo("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Multiplataforma","Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        arrayCiclos.add(c);
        c = new Ciclo("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Web","ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
        arrayCiclos.add(c);
    }

    public void recorrerArray(int id)
    {
        arrayAux = new ArrayList<Ciclo>();
        switch (id){
            case 1:
                for (Ciclo aux: arrayCiclos)
                {
                    if (aux.getFamiliaProfessional() == "EMPRESA")
                    {
                        if (aux.getTipus()=="Mitjà")
                        {
                            btn1 = true;
                        }
                        if (aux.getTipus()=="Superior")
                        {
                            btn2 = true;
                        }
                        arrayAux.add(aux);
                    }
                }
                break;

            case 2:
                for (Ciclo aux: arrayCiclos)
                {
                    if (aux.getFamiliaProfessional() == "ESPORT")
                    {
                        if (aux.getTipus()=="Mitjà")
                        {
                            btn1 = true;
                        }
                        if (aux.getTipus()=="Superior")
                        {
                            btn2 = true;
                        }
                        arrayAux.add(aux);
                    }
                }
                break;
            case 3:
                for (Ciclo aux: arrayCiclos)
                {
                    if (aux.getFamiliaProfessional() == "INFORMÀTICA")
                    {
                        if (aux.getTipus()=="Mitjà")
                        {
                            btn1 = true;
                        }
                        if (aux.getTipus()=="Superior")
                        {
                            btn2 = true;
                        }
                        arrayAux.add(aux);
                    }
                }
                break;
        }
    }
}
