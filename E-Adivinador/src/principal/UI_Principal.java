package principal;



import interfazAdivinador.*;
import interfazPensador.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class UI_Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Principal frame = new UI_Principal();
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
	public UI_Principal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBienvenidoAlTest = new JLabel("Bienvenido al Test de la Adivinanza");
		lblBienvenidoAlTest.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenidoAlTest.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblquePersonajeDesea = new JLabel("\u00BFQue personaje desea ser?");
		lblquePersonajeDesea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblquePersonajeDesea.setVerticalAlignment(SwingConstants.TOP);
		lblquePersonajeDesea.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnPensador = new JButton("Pensador");
		btnPensador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UI_PersonajePensador ui_pens = new UI_PersonajePensador();
				ui_pens.setVisible(true);
				ui_pens.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		
		JButton btnAdivinador = new JButton("Adivinador");
		btnAdivinador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UI_PersonajeAdivinador ui_pa = new UI_PersonajeAdivinador();
				ui_pa.setVisible(true);
				ui_pa.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(lblBienvenidoAlTest))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(118)
							.addComponent(lblquePersonajeDesea))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(99)
							.addComponent(btnPensador)
							.addGap(74)
							.addComponent(btnAdivinador)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblBienvenidoAlTest)
					.addGap(18)
					.addComponent(lblquePersonajeDesea)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPensador)
						.addComponent(btnAdivinador))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
