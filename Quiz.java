/*-----------------------------------------------
Project Name -: MCQ questions using JAVA Swing library.
Purpose -: Show 10 MCQ questions and Calculate the Result in the End

Pre-Requisites 
' JRE & JDK should be installed
' Basic Knowledge of Java Swing and AWT

' Algorithm: 
 Step 1: Create the GUI Panel
 Step 2: Add Action Listener to change screen when Next Button is pressed
 Step 3: Update the Question and Answer Options Text
 Step 4: Check the Results
 Step 5: Print the result in a new Message dialog box.
 
-----------------------------------------------*/
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* ============================================================================================
  Step 1: Create the GUI Panel
 =========================================================================================== */

class gui extends JFrame implements ActionListener{
        JLabel label;
	JRadioButton option[]=new JRadioButton[4];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];


			        gui()
				{
			                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setLayout(null);
					setLocation(500,100);
					setVisible(true);
					setSize(600,400);
			                setTitle("Quiz Application using java");
					label=new JLabel();
					label.setText("Que1: Which one among these is not a datatype");
					add(label);

					// Radio Button
					bg=new ButtonGroup();
					for(int i=0;i<4;i++)
					{
						option[i]=new JRadioButton();	
						add(option[i]);
			        		// bg.add(option[i]);
			                }

			               // Next Button 
					b1=new JButton("Next");
			                b1.addActionListener(this); // Actionlistner added
			                b2=new JButton("Result");
			                b2.setEnabled(false);
			                b2.addActionListener(this); // Adding it to pane
			                add(b2);
					add(b1);
					set();

						// To set the question bounds.
							label.setBounds(30,40,450,20);


						// To set the question bounds.
							option[0].setBounds(50,80,100,20);
							option[1].setBounds(50,110,100,20);
							option[2].setBounds(50,140,100,20);
							option[3].setBounds(50,170,100,20);
							b1.setBounds(100,240,100,30);
					        b2.setBounds(270,240,100,30);
					
				}
	/* ============================================================================================
	  Step 2: Add Action Listener to change screen when Next Button is pressed
	 =========================================================================================== */
					        @Override
					        public void actionPerformed(ActionEvent ae) {
					            if(ae.getSource()==b1){
					        // Every time Next button is pressed count is updated. Based on this count we know which quesiton to display next
					            if(check())
					                count=count+1;     
					            current++;
					            set();
					            // If last Question. Enable the Results button
								if(current==9)
								{
									b1.setEnabled(false);
									b2.setEnabled(true);
									b2.setText("Result");
								}
					                        
					            }
					            
					            if(ae.getActionCommand().equals("Result"))
							{   // Check whether the answer is correct or not:
								if(check()) 
					                          {count=count+1;}

								// Show the number of correct answers
								JOptionPane.showMessageDialog(this,"Correct Answers ="+count);      //Step 5: Printing the result
								System.exit(0);
							}
					        }

        
        /* ============================================================================================
	 Step 3: Adding Questions 
	 =========================================================================================== */	
					        void set()
						{
							
							if(current==0)
							{
								label.setText("Que1: Which one among these is not a datatype");
								option[0].setText("int");option[1].setText("Float");option[2].setText("boolean");option[3].setText("char");	
							}
							if(current==1)
							{
								label.setText("Que2: Which class is available to all the class automatically");
								option[0].setText("Swing");option[1].setText("Applet");option[2].setText("Object");option[3].setText("ActionEvent");
							}
							if(current==2)
							{
								label.setText("Que3: Which package is directly available to our class without importing it");
								option[0].setText("swing");option[1].setText("applet");option[2].setText("net");option[3].setText("lang");
							}
							if(current==3)
							{
								label.setText("Que4: String class is defined in which package");
								option[0].setText("lang");option[1].setText("Swing");option[2].setText("Applet");option[3].setText("awt");
							}
							if(current==4)
							{
								label.setText("Que5: Which of the following is not a Java features?");
								option[0].setText("Use of pointers");option[1].setText("Dynamic");option[2].setText("Architecture Neutral");option[3].setText("Object-oriented");
							}
							if(current==5)
							{
								label.setText("Que6: Which one among these is not a keyword");
								option[0].setText("class");option[1].setText("int");option[2].setText("get");option[3].setText("if");
							}
							if(current==6)
							{
								label.setText("Que7: Which one among these is not a class ");
								option[0].setText("Swing");option[1].setText("Actionperformed");option[2].setText("ActionEvent");option[3].setText("Button");
							}
							if(current==7)
							{
								label.setText("Que8: which one among these is not a function of Object class");
								option[0].setText("toString");option[1].setText("finalize");option[2].setText("equals");option[3].setText("getDocumentBase");		
							}
							if(current==8)
							{
								label.setText("Que9: which function is not present in Applet class");
								option[0].setText("init");option[1].setText("main");option[2].setText("start");option[3].setText("destroy");
							}
							if(current==9)
							{
								label.setText("Que10: Which one among these is not a valid component");
								option[0].setText("JButton");option[1].setText("JList");option[2].setText("JButtonGroup");option[3].setText("JTextArea");
							}
							label.setBounds(30,40,450,20);
							for(int i=0,j=0;i<=90;i+=30,j++)
								option[j].setBounds(50,80+i,200,20);
						}



  /* ============================================================================================
	  Step 4: Check the Results
	 =========================================================================================== */

						boolean check()
						{
							if(current==0)
								return(option[1].isSelected());
							if(current==1)
								return(option[2].isSelected());
							if(current==2)
								return(option[3].isSelected());
							if(current==3)
								return(option[0].isSelected());
							if(current==4)
								return(option[0].isSelected());
							if(current==5)
								return(option[2].isSelected());
							if(current==6)
								return(option[1].isSelected());
							if(current==7)
								return(option[3].isSelected());
							if(current==8)
								return(option[1].isSelected());
							if(current==9)
								return(option[2].isSelected());
							return false;
						}


					    public static void main(String args[]){
					    	// Calling of gui
					       new gui();
					    }   
					}