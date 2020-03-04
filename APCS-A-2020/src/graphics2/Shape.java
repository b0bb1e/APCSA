package graphics2;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Faith Okamoto
//Date - 3/4
//Class -
//Lab  -

import java.awt.Color; 
import java.awt.Graphics;

public class Shape
{
   //instance variables
	private int xPos, yPos, width, height, xSpeed, ySpeed;
	private Color color;
	
   /*
    *The constructor is used to initialize all instance variables.
    *The constructor makes the object.
    */
   public Shape(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
		xSpeed = xSpd;
		ySpeed = ySpd;
   }

      /*
    *The draw method draws the shape on the screen.
    */
   public void draw(Graphics window)
   {
	   window.setColor(color);
	   window.fillRect(xPos, yPos, width, height);
	   window.drawArc(xPos - width / 2, yPos + height / 2, width * 2, height * 2, 135, 270);
	   window.setColor(color.darker());
	   window.fillRoundRect(xPos, yPos + height, width, height, 50, 25);
	   window.setColor(color.brighter().brighter());
	   window.fillOval(xPos - width / 2, yPos - height, width * 2, height);
   }

   /*
    *This draw method will be used to erase the shape.
    */
   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(xPos, yPos, width, height);
   }

   public void moveAndDraw(Graphics window)
   {
    	xPos += xSpeed;
    	yPos += ySpeed;
    	draw(window);
   }

   public int getX() {return xPos;}
   
   public int getY() {return yPos;}
   
   public int getWidth() {return width;}
   
   public int getHeight() {return height;}
   
   public int getXSpeed() {return xSpeed;}
   
   public int getYSpeed() {return ySpeed;}

   public void setX(int x) {xPos = x;}
   
   public void setY(int y) {yPos = y;}
   
   public void setXSpeed(int xSpd) {xSpeed = xSpd;}
   
   public void setYSpeed(int ySpd) {ySpeed = ySpd;}

   public String toString()
   {
	   return xPos + " " + yPos + " " + width + " " + height + " " + color + " " + xSpeed + " " + ySpeed;
   }
}