package com.cars24.auction.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Collection;

@Getter
@AllArgsConstructor
public class AuthenticationResponse implements Serializable {
	private final String jwt;
	private final Collection<?> role;
}
