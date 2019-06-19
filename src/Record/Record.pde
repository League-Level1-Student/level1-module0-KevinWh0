PImage pictureOfRecord;                        //as member variable
import processing.sound.*;
SoundFile file;//at the very top of your sketch
Boolean playing = false;
int rot = 0;
void setup() {
  size(600, 600);                                 //in setup method
  pictureOfRecord= loadImage("record.png");      //in setup method
  // Load a soundfile from the /data folder of the sketch and play it back
  file = new SoundFile(this, "awesomeTrack.mp3");
}


void rotateImage(PImage image, int amountToRotate) {
  imageMode(CENTER);
  pushMatrix();
  rotate(radians(amountToRotate));
}

void draw() {
  clear();
  background(255);
  if (playing == true) {
    rot++;

    if (!file.isPlaying()) {
      file.play();
    }
  } else {
    file.stop();
  }
  print("\n playing: "+playing);
  rotateImage(pictureOfRecord, rot);
  image(pictureOfRecord, 0, 0, width, height);
  popMatrix();
}

void mousePressed() {
  print("Pressed");
  if (playing == true) {
    playing = false;
  } else {
    playing = true;
  }
}
