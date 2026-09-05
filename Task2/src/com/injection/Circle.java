package com.injection;

public class Circle implements Shape {
    private Draw2d draw2d;
    public Circle(Draw2d draw2d)
    {
        this.draw2d=draw2d;
    }
    @Override
    public void Draw()
    {
        draw2d.Draw("Cricle");
    }
}
