package interfazAdivinador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UI_PersonajeAdivinador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNIngresado;
	private JTextField tfBien;
	private JTextField tfRegular;
	static String numeroElegido;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_PersonajeAdivinador frame = new UI_PersonajeAdivinador();
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
	public UI_PersonajeAdivinador() {
		setResizable(false);
		
		Adivinar a = new Adivinar();
		System.out.println("Se esta ejecutando esto amigo");
		int[] numeroEleg = a.elegirnum4();
		numeroElegido = (numeroEleg[0] +""+ numeroEleg[1] +""+ numeroEleg[2] +""+ numeroEleg[3]);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtReglas = new JTextPane();
		txtReglas.setEditable(false);
		txtReglas.setBackground(UIManager.getColor("Button.background"));
		txtReglas.setText("                    Se ha elegido un n\u00FAmero de 4 cifras de las cu\u00E1les niguna se repite. \r\n                  Si adivinas un n\u00FAmero es su posici\u00F3n correcta se contar\u00E1 como bien.\r\n          Si adivinas un n\u00FAmero pero su posici\u00F3n es incorrecta se contar\u00E1 como regular.");
		
		tfNIngresado = new JTextField();
		tfNIngresado.setHorizontalAlignment(SwingConstants.CENTER);
		tfNIngresado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 4;
				if(tfNIngresado.getText().length()==limite)
					e.consume();
			}
		});
		
		tfNIngresado.setColumns(10);
		
		
		JLabel lblIngreseElNmero = new JLabel("Ingrese el n\u00FAmero que crea correcto.");
		lblIngreseElNmero.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblReglas = new JLabel("Reglas");
		lblReglas.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnAdivinar = new JButton("Adivinar!");
		btnAdivinar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int num = Integer.parseInt(tfNIngresado.getText());
					
					String numeroPersonaje = tfNIngresado.getText();
					
					if(numeroElegido.equals(numeroPersonaje)) {
						
						UI_Ganaste ui_ganar = new UI_Ganaste();
						ui_ganar.setVisible(true);
						ui_ganar.setLocationRelativeTo(null);
						dispose();
						
					}else {
						
						Adivinar adivinar = new Adivinar();
						int respuesta[] = new int[2];
						respuesta = adivinar.intentoAdivinar(numeroElegido,numeroPersonaje);
						
						tfBien.setText(String.valueOf(respuesta[0]));
						tfRegular.setText(String.valueOf(respuesta[1]));
						
					}
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Ingrese solo números por favor");
				}

			}
		});
		
		JLabel lblBien = new JLabel("BIEN");
		lblBien.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblRegulares = new JLabel("REGULARES");
		lblRegulares.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		tfBien = new JTextField();
		tfBien.setBackground(Color.WHITE);
		tfBien.setHorizontalAlignment(SwingConstants.CENTER);
		tfBien.setEditable(false);
		tfBien.setColumns(10);
		
		tfRegular = new JTextField();
		tfRegular.setBackground(Color.WHITE);
		tfRegular.setHorizontalAlignment(SwingConstants.CENTER);
		tfRegular.setEditable(false);
		tfRegular.setColumns(10);
		
		JLabel lblIntenteAdivinar = new JLabel("Intente Adivinar !");
		lblIntenteAdivinar.setFont(new Font("Tahoma", Font.BOLD, 18));
											
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(tfBien, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(lblBien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(47))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tfNIngresado, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRegulares)
						.addComponent(btnAdivinar)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(tfRegular, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(131, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(145)
					.addComponent(lblIntenteAdivinar)
					.addContainerGap(149, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(194)
					.addComponent(lblReglas)
					.addContainerGap(214, Short.MAX_VALUE))
				.addComponent(txtReglas, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(110)
					.addComponent(lblIngreseElNmero)
					.addContainerGap(111, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIntenteAdivinar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblReglas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtReglas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblIngreseElNmero)
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfNIngresado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdivinar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBien)
						.addComponent(lblRegulares))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfBien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfRegular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
