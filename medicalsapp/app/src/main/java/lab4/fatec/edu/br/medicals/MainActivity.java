package lab4.fatec.edu.br.medicals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities.Convenio;
import lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities.ConvenioList;
import lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities.Especialidade;
import lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities.Profissional;

public class MainActivity extends AppCompatActivity {

    public ConvenioList convenios = new ConvenioList();
    private Spinner spConvenio;
    private Spinner spEspecialidade;

    public MainActivity() throws Exception {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spConvenio = (Spinner) findViewById(R.id.spConvenio);
        //Populando o Spinner com os Convênios
        ArrayAdapter<String> adapterConvenios = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,convenios.getTitulosConvenios());
        ArrayAdapter<String> spinnerArrayAdapter = adapterConvenios;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spConvenio.setAdapter(spinnerArrayAdapter);

        spEspecialidade = (Spinner) findViewById(R.id.spEspecialidade);
        //Populando o Spinner com as especialidades médicas
        ArrayAdapter<String> adapterEspecialidades = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,convenios.getTitulosEspecialidades());
        ArrayAdapter<String>spArrayAdapterEspecialidade = adapterEspecialidades;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEspecialidade.setAdapter(spArrayAdapterEspecialidade);
    }

    public void buscar(View view){
        TextView spResultado = (TextView) findViewById(R.id.tvResultado);

        String convenio = String.valueOf(spConvenio.getSelectedItem());
        String especialidade = String.valueOf(spEspecialidade.getSelectedItem());

        List<Profissional> result = convenios.buscarDetalhesDeProfissionaisPorEspecialidade(new Convenio(convenio),new Especialidade(especialidade));

        StringBuilder finalResult =  new StringBuilder();

        if(result!=null){
            for (Profissional p:result) {
                finalResult.append(p.toString());
            }
            spResultado.setText(finalResult);
            spResultado.setMovementMethod(new ScrollingMovementMethod());
        }else{
            spResultado.setText(R.string.msg_erro);
        }
    }
}
