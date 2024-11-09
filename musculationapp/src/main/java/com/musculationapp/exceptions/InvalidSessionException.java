package com.musculationapp.exceptions;

public class InvalidSessionException extends RuntimeException
{
	public InvalidSessionException(String message)
	{
		super(message);
	}
}
