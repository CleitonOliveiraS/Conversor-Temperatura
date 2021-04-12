import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Temperatura extends JFrame{

    private JPanel painel;
    private JLabel temperatureJLabel;
    private JTextField temperatureJText;
    private JRadioButton celsiusConvertJRadioButton;
    private JRadioButton fahrenheitConvertJRadioButton;
    private JRadioButton kelvinConvertJRadioButton;
    private JRadioButton celsiusJRadioButton;
    private JRadioButton fahrenheitJRadioButton;
    private JRadioButton kelvinJRadioButton;
    private RadioButtonHandler handler;
    private JButton calcJButton;
    private JTextField resultJTextField;

    public Temperatura(){
        super("Temperatura");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        handler = new RadioButtonHandler();
        painel = new JPanel();
        painel.setBorder(new EmptyBorder(5, 5, 5, 5));
        painel.setLayout(new GridLayout(5, 1));

        JPanel painelEntradaTexto = new JPanel(new GridLayout(1, 1));
        temperatureJLabel = new JLabel("Valor Temperatura: ");
        temperatureJText = new JTextField();
        painelEntradaTexto.add(temperatureJLabel);
        painelEntradaTexto.add(temperatureJText);

        painel.add(painelEntradaTexto);

        JPanel painelRadioButton = new JPanel();
        celsiusJRadioButton = new JRadioButton("Celsius");
        celsiusJRadioButton.addItemListener(handler);
        fahrenheitJRadioButton = new JRadioButton("Fahrenheit");
        fahrenheitJRadioButton.addItemListener(handler);
        kelvinJRadioButton = new JRadioButton("Kelvin");
        kelvinJRadioButton.addItemListener(handler);
        ButtonGroup selectButtonGroup = new ButtonGroup();
        selectButtonGroup.add(celsiusJRadioButton);
        selectButtonGroup.add(fahrenheitJRadioButton);
        selectButtonGroup.add(kelvinJRadioButton);

        painelRadioButton.setLayout(new BoxLayout(painelRadioButton, BoxLayout.X_AXIS));
        JPanel tituloPainelRadioButton = new JPanel();
        tituloPainelRadioButton.setLayout(new GridLayout(1,2));
        tituloPainelRadioButton.add(new JLabel("Tipo da entrada:"));
        painelRadioButton.add(celsiusJRadioButton);
        painelRadioButton.add(fahrenheitJRadioButton);
        painelRadioButton.add(kelvinJRadioButton);
        tituloPainelRadioButton.add(painelRadioButton);

        painel.add(tituloPainelRadioButton);

        JPanel painelConvertRadioButton = new JPanel();
        celsiusConvertJRadioButton = new JRadioButton("Celsius");
        fahrenheitConvertJRadioButton = new JRadioButton("Fahrenheit");
        kelvinConvertJRadioButton = new JRadioButton("Kelvin");
        ButtonGroup convertButtonGroup = new ButtonGroup();
        convertButtonGroup.add(celsiusConvertJRadioButton);
        convertButtonGroup.add(fahrenheitConvertJRadioButton);
        convertButtonGroup.add(kelvinConvertJRadioButton);
        painelConvertRadioButton.setLayout(new BoxLayout(painelConvertRadioButton, BoxLayout.X_AXIS));
        JPanel titulopainelConvertRadioButton = new JPanel();
        titulopainelConvertRadioButton.setLayout(new GridLayout(1,2));
        titulopainelConvertRadioButton.add(new JLabel("Tipo a ser convertido:"));
        painelConvertRadioButton.add(celsiusConvertJRadioButton);
        painelConvertRadioButton.add(fahrenheitConvertJRadioButton);
        painelConvertRadioButton.add(kelvinConvertJRadioButton);
        titulopainelConvertRadioButton.add(painelConvertRadioButton);

        painel.add(titulopainelConvertRadioButton);

        JPanel painelCalcular = new JPanel();
        calcJButton = new JButton("Calcular");
        painelCalcular.setLayout(new BorderLayout());
        painelCalcular.add(calcJButton, BorderLayout.SOUTH);

        painel.add(painelCalcular);

        JPanel painelSaida = new JPanel();
        resultJTextField = new JTextField();
        painelSaida.setLayout(new BorderLayout());
        painelSaida.add(resultJTextField, BorderLayout.CENTER);

        painel.add(painelSaida);

        add(painel);
        calcJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (celsiusJRadioButton.isSelected()){
                    if (fahrenheitConvertJRadioButton.isSelected()){

                        try{
                            Double entrada = Double.valueOf(temperatureJText.getText());
                            Double resultado = (entrada * 9/5)+32;
                            resultJTextField.setText(resultado.toString());
                        }catch (NumberFormatException exception){
                            JOptionPane.showMessageDialog(null, "Favor entrar com um valor", "Campo valor temperatura vazio.", JOptionPane.ERROR_MESSAGE);
                        }

                    }else if (kelvinConvertJRadioButton.isSelected()){

                        try{
                            Double entrada = Double.valueOf(temperatureJText.getText());
                            Double resultado = entrada + 273.15;
                            resultJTextField.setText(resultado.toString());
                        }catch (NumberFormatException exception){
                            JOptionPane.showMessageDialog(null, "Favor entrar com um valor", "Campo valor temperatura vazio.", JOptionPane.ERROR_MESSAGE);
                        }

                    }else {

                        JOptionPane.showMessageDialog(null, "Nenhum Opção para conversão foi selecionada", "Checkbox não selecionado.", JOptionPane.ERROR_MESSAGE);

                    }
                }else if (fahrenheitJRadioButton.isSelected()){
                    if (celsiusConvertJRadioButton.isSelected()){

                        try{
                            Double entrada = Double.valueOf(temperatureJText.getText());
                            Double resultado = (entrada - 32)* 5/9;
                            resultJTextField.setText(resultado.toString());
                        }catch (NumberFormatException exception){
                            JOptionPane.showMessageDialog(null, "Favor entrar com um valor", "Campo valor temperatura vazio.", JOptionPane.ERROR_MESSAGE);
                        }

                    }else if (kelvinConvertJRadioButton.isSelected()){

                        try{
                            Double entrada = Double.valueOf(temperatureJText.getText());
                            Double resultado =  ((entrada - 32) * 5/9) + 273.15;
                            resultJTextField.setText(resultado.toString());
                        }catch (NumberFormatException exception){
                            JOptionPane.showMessageDialog(null, "Favor entrar com um valor", "Campo valor temperatura vazio.", JOptionPane.ERROR_MESSAGE);
                        }

                    }else {
                        JOptionPane.showMessageDialog(null, "Nenhum Opção para conversão foi selecionada", "Checkbox não selecionado.", JOptionPane.ERROR_MESSAGE);
                    }
                }else if (kelvinJRadioButton.isSelected()){
                    if (celsiusConvertJRadioButton.isSelected()){

                        try{
                            Double entrada = Double.valueOf(temperatureJText.getText());
                            Double resultado = entrada - 273.15;
                            resultJTextField.setText(resultado.toString());
                        }catch (NumberFormatException exception){
                            JOptionPane.showMessageDialog(null, "Favor entrar com um valor", "Campo valor temperatura vazio.", JOptionPane.ERROR_MESSAGE);
                        }

                    }else if (fahrenheitConvertJRadioButton.isSelected()){

                        try{
                            Double entrada = Double.valueOf(temperatureJText.getText());
                            Double resultado =  ((entrada - 273.15) * 9/5) + 32;
                            resultJTextField.setText(resultado.toString());
                        }catch (NumberFormatException exception){
                            JOptionPane.showMessageDialog(null, "Favor entrar com um valor", "Campo valor temperatura vazio.", JOptionPane.ERROR_MESSAGE);
                        }

                    }else {
                        JOptionPane.showMessageDialog(null, "Nenhum Opção para conversão foi selecionada", "Checkbox não selecionado.", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        setVisible(true);

    }

    public static void main(String[] args){
        new Temperatura();
    }

    private class RadioButtonHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {

            celsiusConvertJRadioButton.setEnabled(true);
            fahrenheitConvertJRadioButton.setEnabled(true);
            kelvinConvertJRadioButton.setEnabled(true);

            if (celsiusJRadioButton.isSelected()){
                if (celsiusConvertJRadioButton.isSelected()){
                    fahrenheitConvertJRadioButton.setSelected(true);
                }
                celsiusConvertJRadioButton.setEnabled(false);

                fahrenheitJRadioButton.setSelected(false);
                kelvinConvertJRadioButton.setSelected(false);
            }else if (fahrenheitJRadioButton.isSelected()){
                if (fahrenheitConvertJRadioButton.isSelected()){
                    kelvinConvertJRadioButton.setSelected(true);
                }
                fahrenheitConvertJRadioButton.setEnabled(false);

                celsiusJRadioButton.setSelected(false);
                kelvinJRadioButton.setSelected(false);
            }else {
                if (kelvinConvertJRadioButton.isSelected()){
                    celsiusConvertJRadioButton.setSelected(true);
                }
                kelvinConvertJRadioButton.setEnabled(false);

                fahrenheitJRadioButton.setSelected(false);
                celsiusJRadioButton.setSelected(false);
            }
        }
    }

}
