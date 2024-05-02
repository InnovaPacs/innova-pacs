package com.persist.innovapacs.adapter.in.rest.impl;

import com.persist.innovapacs.adapter.in.rest.IModalityController;
import com.persist.innovapacs.adapter.in.rest.model.ModalityRestModel;
import com.persist.innovapacs.adapter.in.rest.model.PageRestModel;
import com.persist.innovapacs.application.ports.in.modality.CreateModalityCommand;
import com.persist.innovapacs.application.ports.in.modality.GetModalitiesQuery;
import com.persist.innovapacs.application.ports.in.modality.PatchModalityCommand;
import com.persist.innovapacs.domain.Modality;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@AllArgsConstructor
@RequestMapping(path = "/v1/modalities")
public class ModalityController implements IModalityController {
	private final GetModalitiesQuery getModalitiesQuery;
	private final CreateModalityCommand createModalityCommand;
	private final PatchModalityCommand patchModalityCommand;

	@Override
	public PageRestModel<ModalityRestModel> findAll(Integer size, Integer page) {
		log.info("GET /v1/modalities");

		Page<Modality> modalities = getModalitiesQuery.execute(GetModalitiesQuery.Data.builder()
				.page(page)
				.size(size)
				.build());
		return new PageRestModel<ModalityRestModel>().fromDomain(modalities, ModalityRestModel::fromDomain);
	}

	@Override
	public ModalityRestModel create(ModalityRestModel modalityRestModel) {
		log.info("POST /v1/modalities");

		Modality modality = createModalityCommand.execute(CreateModalityCommand.Data.builder()
						.name(modalityRestModel.getName())
						.description(modalityRestModel.getDescription())
				.build());

		return ModalityRestModel.fromDomain(modality);
	}

	@Override
	public ModalityRestModel update(ModalityRestModel modalityRestModel) {
		log.info("PATCH /v1/modalities");

		Modality modality = patchModalityCommand.execute(PatchModalityCommand.Data.builder()
				.name(modalityRestModel.getName())
				.description(modalityRestModel.getDescription())
				.build());

		return ModalityRestModel.fromDomain(modality);
	}
}
