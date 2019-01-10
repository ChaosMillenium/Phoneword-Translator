package phonewordTranslator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TranslatorView {

	private JFrame frmPhonewordTranslator;
	private Translator translator;
	private JTextArea textArea, textArea_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TranslatorView window = new TranslatorView();
					window.frmPhonewordTranslator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TranslatorView() {
		translator = new Translator();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPhonewordTranslator = new JFrame();
		frmPhonewordTranslator.setTitle("Phoneword Translator");
		frmPhonewordTranslator.setBounds(100, 100, 450, 300);
		frmPhonewordTranslator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmPhonewordTranslator.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblText = new JLabel("Text");
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.insets = new Insets(0, 0, 5, 5);
		gbc_lblText.gridx = 0;
		gbc_lblText.gridy = 0;
		frmPhonewordTranslator.getContentPane().add(lblText, gbc_lblText);
		
		JLabel lblPhoneword = new JLabel("Phoneword");
		GridBagConstraints gbc_lblPhoneword = new GridBagConstraints();
		gbc_lblPhoneword.insets = new Insets(0, 0, 5, 0);
		gbc_lblPhoneword.gridx = 1;
		gbc_lblPhoneword.gridy = 0;
		frmPhonewordTranslator.getContentPane().add(lblPhoneword, gbc_lblPhoneword);
		
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		frmPhonewordTranslator.getContentPane().add(scrollPane, gbc_scrollPane);
		
		textArea_1 = new JTextArea();
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 7;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 1;
		frmPhonewordTranslator.getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		JButton btnTextToPhoneword = new JButton("Text to Phoneword");
		btnTextToPhoneword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textArea_1.setText(translator.translateTextToPhone(textArea.getText()));
			}
		});
		GridBagConstraints gbc_btnTextToPhoneword = new GridBagConstraints();
		gbc_btnTextToPhoneword.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTextToPhoneword.insets = new Insets(0, 0, 0, 5);
		gbc_btnTextToPhoneword.gridx = 0;
		gbc_btnTextToPhoneword.gridy = 8;
		frmPhonewordTranslator.getContentPane().add(btnTextToPhoneword, gbc_btnTextToPhoneword);
		
		JButton btnPhonewordToText = new JButton("Phoneword to Text");
		btnPhonewordToText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				textArea.setText(translator.translatePhoneToText(textArea_1.getText()));
			}
		});
		GridBagConstraints gbc_btnPhonewordToText = new GridBagConstraints();
		gbc_btnPhonewordToText.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPhonewordToText.gridx = 1;
		gbc_btnPhonewordToText.gridy = 8;
		frmPhonewordTranslator.getContentPane().add(btnPhonewordToText, gbc_btnPhonewordToText);
	}

}
