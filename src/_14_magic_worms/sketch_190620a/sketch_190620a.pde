

float frequency = .005;
float noiseInterval = PI;
void setup(){
  //size(800,800);  
  fullScreen();
    background(0,0,0);
  
}


void draw(){
  //clear();
  fill(0,0,0,10);
  rect(0,0,width,height);
  for(int i=0; i < 50; i++){
    //for(int j=0; j < 500; j++){
      fill(255,0,0);
      noStroke();
      ellipse(getWormX(width*(i*i)),getWormY(height*i),10,10);
    //}
  }
  
  
}




    void makeMagical() {
        fill( 0, 0, 0, 10 );
        rect(0, 0, width, height);
        noStroke();
    }

    float getWormX(int i) {
        return map(noise(i*noiseInterval + frameCount * frequency), 0, 1, 0, width);
    }

    float getWormY(int i) {
        return map(noise(i*noiseInterval+1 + frameCount * frequency), 0, 1, 0, height);
    }    
