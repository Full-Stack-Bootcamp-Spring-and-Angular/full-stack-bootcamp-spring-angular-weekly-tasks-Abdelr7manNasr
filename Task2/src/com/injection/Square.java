package com.injection;
public class Square implements Shape {
    private Draw2d draw2d;
    public void setDraw2d(Draw2d draw2d){
        this.draw2d=draw2d;
    }
    @Override
    public void Draw() {
        draw2d.Draw("Square");
    }
}
