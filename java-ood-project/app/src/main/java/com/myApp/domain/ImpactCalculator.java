package com.myApp.domain;

public interface ImpactCalculator {
    double calculate (Product product); // obsahuje jak materiály tak životnost, obě strategie využijí
}
