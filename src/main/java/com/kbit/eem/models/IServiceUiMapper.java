package com.kbit.eem.models;

import java.util.List;

public interface IServiceUiMapper<TModelUI, TModelService> {
	public TModelUI MapToUIModel(TModelService source);

	public TModelService MapToServiceModel(TModelUI source);

	public List<TModelUI> MapToUIModel(List<TModelService> source);

	public List<TModelService> MapToServiceModel(List<TModelUI> source);
}
