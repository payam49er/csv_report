package edu.mit.star.csv_report;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Main extends JFrame
{
	private static final long serialVersionUID = 1L;
	JTextArea input;
	JButton calculate;
	JTextArea report;

	@Override
	public void addNotify()
	{
		super.addNotify();
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS));
		input = new JTextArea(12, 40);
		input.setBorder(BorderFactory.createTitledBorder("Input"));
		calculate = new JButton("Calculate");
		calculate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Calculate();
			}
		});
		report = new JTextArea(12,40);
		report.setBorder(BorderFactory.createTitledBorder("Report"));
	    report.setVisible(true);
		c.add(input);
		c.add(calculate);
		c.add(report);
		
	}
	
	public void Calculate()
	{
		GenerateReport m = new GenerateReport();
		String result = m.Parsecsv(input.getText());
		this.report.setText(result);
	    
	}

	
	public static void main(String[] args)
	{
		try
		{
			SwingUtilities.invokeAndWait(new Runnable()
			{

				@Override
				public void run()
				{
					Main m = (new Main());
					m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					m.pack();
					m.setVisible(true);
					
					
				}
			});
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}
}
