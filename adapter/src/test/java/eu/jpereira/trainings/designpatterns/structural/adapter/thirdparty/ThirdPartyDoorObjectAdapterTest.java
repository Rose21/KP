package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorObjectAdapter implements Door {
	
	private ThirdPartyDoor door;
	
	ThirdPartyDoorObjectAdapter() {
		door = new ThirdPartyDoor();
	}

	@Override
	public void open(String code) throws IncorrectDoorCodeException {
		try {
			door.unlock(code);
			door.setState(ThirdPartyDoor.DoorState.OPEN);
		} catch (CannotUnlockDoorException e) {
			// TODO Auto-generated catch block
			throw new IncorrectDoorCodeException();
		} catch (CannotChangeStateOfLockedDoor e) {
			throw new IncorrectDoorCodeException();
		}
	}

	@Override
	public void close() {
		try {
			door.setState(ThirdPartyDoor.DoorState.CLOSED);
		} catch (CannotChangeStateOfLockedDoor e) {
			return;
		}
		door.lock();
	}

	@Override
	public boolean isOpen() {
		if (door.getState().equals(ThirdPartyDoor.DoorState.OPEN))
			return true;
		return false;
	}

	@Override
	public void changeCode(String oldCode, String newCode,
			String newCodeConfirmation) throws IncorrectDoorCodeException,
			CodeMismatchException {
		if (!newCode.equals(newCodeConfirmation))
			throw new CodeMismatchException();
		
		try {
			open(oldCode);
			door.setNewLockCode(newCode);
		} catch (IncorrectDoorCodeException e) {
			throw new IncorrectDoorCodeException();
		} catch (CannotChangeCodeForUnlockedDoor e2) {
			throw new IncorrectDoorCodeException();
		}
	}

	@Override
	public boolean testCode(String code) {
		try {
			door.setState(ThirdPartyDoor.DoorState.CLOSED);
		} catch (CannotChangeStateOfLockedDoor e) {
			return false;
		}
		door.lock();
		return true;
	}

}
