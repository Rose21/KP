package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorAdaper extends ThirdPartyDoor implements Door {

	@Override
	public void open(String code) throws IncorrectDoorCodeException {
		// TODO Auto-generated method stub
		try {
			unlock(code);
			setState(DoorState.OPEN);
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
			setState(DoorState.CLOSED);
		} catch (CannotChangeStateOfLockedDoor e) {
			return;
		}
		lock();
	}

	@Override
	public boolean isOpen() {
		if (getState() == DoorState.OPEN)
			return true;
		return false;
	}

	@Override
	public void changeCode(String oldCode, String newCode,
			String newCodeConfirmation) throws IncorrectDoorCodeException,
			CodeMismatchException {
		// TODO Auto-generated method stub
		if (!newCode.equals(newCodeConfirmation))
			throw new CodeMismatchException();
		
		try {
			open(oldCode);
			setNewLockCode(newCode);
		} catch (IncorrectDoorCodeException e) {
			throw new IncorrectDoorCodeException();
		} catch (CannotChangeCodeForUnlockedDoor e2) {
			throw new IncorrectDoorCodeException();
		}
		
	}

	@Override
	public boolean testCode(String code) {
		// TODO Auto-generated method stub
		try {
			open(code);
		} catch (IncorrectDoorCodeException e) {
			return false;
		}
		close();
		return true;
	}

}
