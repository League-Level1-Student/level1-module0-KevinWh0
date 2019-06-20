import processing.sound.*;

PImage backgroundImage;
int PaddleX = 0;
int PaddleWidth = 100;
SoundFile file;//at the very top of your sketch
int ballX = 0;
int ballY = 0;
int ballXVel = 10;
int ballYVel = 10;

int ballSize = 20;
Boolean Dead = true;

int EpaddleX = 0;


int Score = 0;
void setup() {
  size(320, 480);
  backgroundImage = loadImage("pong.png");
  file = new SoundFile(this, "pong.wav");
}



void draw() {
  if (Dead) {
    ballY = height/2;
    ballX = width/2;
    ballXVel = (round(random(10)))-5;
    ballYVel = (round(random(10)))-5;
    if (ballY == 0) {
      ballY++;
    }
    if (ballX == 0) {
      ballX++;
    }
    Dead = false;
  }
  //Paddle 
  background(0);
  image(backgroundImage, 0, 0, width, height);

  text("Score: " + Score, 10, 10);

  PaddleX = mouseX-(PaddleWidth/2);
  //PaddleX = EpaddleX;
  fill(255);
  rect(PaddleX, height-20, PaddleWidth, 20);


  //Ball
  ellipse(ballX, ballY, ballSize, ballSize);

  //Ball Moving
  ballX += ballXVel;
  ballY += ballYVel;

  //ball hit
  if (PaddleX < ballX && (PaddleX+PaddleWidth) > ballX && height-20 < (ballY+ballSize)) {
    file.play();
    ballXVel -=(ballXVel*2);
    ballYVel -=(ballYVel*2);
  }

  if ((ballX+ballSize) > width || (ballX-ballSize) < 0) {
    ballXVel -=(ballXVel*2);
    //if (!file.isPlaying()) {
      file.play();
    //}
  } else if ((ballY) < 0) {
    Score++;
    Dead = true;
  } else if ((ballY+ballSize) > width*1.5) {
    Score--;
    Dead = true;
  }
  EpaddleX = ballX-(PaddleWidth/2);
  //enemy pong
  rect(EpaddleX, 0, PaddleWidth, 20);
  if (EpaddleX < ballX && (EpaddleX+PaddleWidth) > ballX && 50 > (ballY+ballSize)) {
    ballXVel -=(ballXVel*2);
    ballYVel -=(ballYVel*2);
    //if (!file.isPlaying()) {
      file.play();
    //}
  }
}
