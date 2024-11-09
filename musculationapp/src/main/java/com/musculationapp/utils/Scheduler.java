package com.musculationapp.utils;

import com.musculationapp.models.Session;

import java.time.LocalDate;
import java.util.List;

public class Scheduler
{

	public static boolean canScheduleSession(List<Session> previousSessions, LocalDate newSessionDate,
			String musclesTravailles)
	{
		if (previousSessions.isEmpty())
			return true;

		Session lastSession = previousSessions.get(previousSessions.size() - 1);
		return !lastSession.getMusclesTravailles().equals(musclesTravailles)
				|| lastSession.getDateSession().plusDays(1).isBefore(newSessionDate);
	}
}
