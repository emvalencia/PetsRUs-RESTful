package com.uci.petsrusservice.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/* required to hit the restful api with JAX-RS */
@ApplicationPath("/api")
public class PetsRUsService extends Application {
    /* do nothing */
} 
