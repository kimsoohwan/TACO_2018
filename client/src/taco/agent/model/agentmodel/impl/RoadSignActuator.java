package taco.agent.model.agentmodel.impl;

import java.util.Map;

import hso.autonomy.agent.communication.action.IEffector;
import taco.agent.communication.action.IAudiCupAction;
import taco.agent.communication.action.impl.RoadSignEffector;
import taco.agent.model.agentmodel.IRoadSignActuator;
import taco.agent.model.worldmodel.signdetection.RoadSign;

public class RoadSignActuator extends AudiCupActuator implements IRoadSignActuator
{
	private RoadSign roadSign;

	public RoadSignActuator(String name)
	{
		super(name);
	}

	@Override
	public void setRoadSign(RoadSign roadSign)
	{
		this.roadSign = roadSign;
	}

	@Override
	public boolean createAction(IAudiCupAction action, Map<String, IEffector> effectors)
	{
		if (roadSign == null) {
			return false;
		}
		effectors.put(getName(), new RoadSignEffector(roadSign.getSignType().getValue(), roadSign.getPose().getX(),
										 roadSign.getPose().getY(), roadSign.getPose().getHorizontalAngle().degrees()));
		roadSign = null;
		return true;
	}
}
