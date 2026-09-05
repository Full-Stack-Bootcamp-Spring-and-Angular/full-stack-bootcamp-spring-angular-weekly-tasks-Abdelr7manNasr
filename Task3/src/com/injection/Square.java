package com.injection;
public class Square implements Shape {
    private Draw3d draw3d;
    public void setDraw3d(Draw3d draw3d){
        this.draw3d=draw3d;
    }
    @Override
    public void Draw() {
        draw3d.Draw("Square");
    }
}
