package interfazPensador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_PersonajePensador extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_PersonajePensador frame = new UI_PersonajePensador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_PersonajePensador() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblVamosAPensar = new JLabel("Vamos a Pensar !");
		lblVamosAPensar.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblReglas = new JLabel("Reglas");
		lblReglas.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JTextPane txtpnElijaUnNmero = new JTextPane();
		txtpnElijaUnNmero.setText("                       Elija un n\u00FAmero de 4 cifras de las cu\u00E1les niguna se repita. \r\n       Si la m\u00E1quina adivina un n\u00FAmero es su posici\u00F3n correcta cuentel\u00F3 como bien.\r\nSi la m\u00E1quina adivina un n\u00FAmero pero su posici\u00F3n es incorrecta cuentel\u00F3 como regular.");
		txtpnElijaUnNmero.setEditable(false);
		txtpnElijaUnNmero.setBackground(SystemColor.menu);
		
		JLabel lblElNmeroQue = new JLabel("El n\u00FAmero que usted pens\u00F3 es ");
		lblElNmeroQue.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tfNumero = new JTextField();
		tfNumero.setEditable(false);
		tfNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNumero.setHorizontalAlignment(SwingConstants.CENTER);
		tfNumero.setColumns(10);
		
		JLabel label = new JLabel("?");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblRegular = new JLabel("BIEN");
		
		JLabel lblRegular_1 = new JLabel("REGULAR");
		
		JComboBox cbBien = new JComboBox();
		cbBien.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4"}));
		
		JComboBox cbRegular = new JComboBox();
		cbRegular.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4"}));
		
		Adivinar a = new Adivinar();
		int[] numeroEleg = a.elegirnum4();
		String numeroElegido = (numeroEleg[0] +""+ numeroEleg[1] +""+ numeroEleg[2] +""+ numeroEleg[3]);
		tfNumero.setText(numeroElegido);
		
		JButton btnResponder = new JButton("Responder");
		btnResponder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numBien = cbBien.getSelectedIndex();
				int numRegular = cbRegular.getSelectedIndex();
				
				if(numBien == 4 && numRegular == 0) {
					
					UI_PcGana ui_pc = new UI_PcGana();
					ui_pc.setVisible(true);
					ui_pc.setLocationRelativeTo(null);
					dispose();
					
				}
				
				if(numBien + numRegular < 5){
				
				int numPcAdivina[];
				try {
					numPcAdivina = a.PcAdivina(numBien, numRegular);
					String numero = (numPcAdivina[0] + "" + numPcAdivina[1] + "" + numPcAdivina[2] + "" + numPcAdivina[3]);
					tfNumero.setText(numero);
				} catch (ManejadorExcepciones e1) {
					//e1.printStackTrace();
					dispose();
				}

				
				}else {
					
					JOptionPane.showMessageDialog(null, "Por favor la suma entre Bien y Regular debe ser 4 o menos");
					
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(222)
					.addComponent(lblReglas)
					.addContainerGap(222, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(lblVamosAPensar, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(143, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(135)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblRegular)
							.addGap(61))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cbBien, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(51)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblRegular_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cbRegular, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(15)
					.addComponent(btnResponder)
					.addContainerGap(115, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addComponent(lblElNmeroQue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(112, Short.MAX_VALUE))
				.addComponent(txtpnElijaUnNmero, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblVamosAPensar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblReglas)
					.addGap(11)
					.addComponent(txtpnElijaUnNmero, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblElNmeroQue)
						.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegular_1)
						.addComponent(lblRegular))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbBien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbRegular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnResponder))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
