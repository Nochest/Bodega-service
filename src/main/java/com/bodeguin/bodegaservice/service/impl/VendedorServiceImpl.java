package com.bodeguin.bodegaservice.service.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodeguin.bodegaservice.dto.CreateVendedorDto;
import com.bodeguin.bodegaservice.dto.VendedorDto;
import com.bodeguin.bodegaservice.entities.Vendedor;
import com.bodeguin.bodegaservice.repository.VendedorRepository;
import com.bodeguin.bodegaservice.service.VendedorService;
import com.example.bodeguinmicroinventario.dto.Categoriadto;
import com.example.bodeguinmicroinventario.entities.Categoria;
import com.example.bodeguinmicroinventario.exceptions.ProductoNotFoundException;

@Service
public class VendedorServiceImpl implements VendedorService {

	@Autowired
	private VendedorRepository vendedorRepository;
	
    private static final ModelMapper modelmapper = new ModelMapper();

	@Override
	public VendedorDto getVendedorById(Long id) throws Exception {
		return modelmapper.map(getVendedorEntity(id), VendedorDto.class);
	}

	@Override
	public VendedorDto createVendedor(CreateVendedorDto createVendedorDto) throws Exception {
		Vendedor vendedor = new Vendedor();
		vendedor.setNombre(createVendedorDto.getNombre());
		vendedor.setDni(createVendedorDto.getDni());
		try {
			vendedor = vendedorRepository.save(vendedor);
		}catch (Exception e) {
            throw new Exception("internal error");
		}
        return modelmapper.map(getVendedorEntity(vendedor.getId()),VendedorDto.class);
	}

	@Override
	public List<VendedorDto> getVendedores() throws Exception {
		 List<Vendedor> vendedores =vendedorRepository.findAll();
	        return vendedores.stream().map(vendedor -> modelmapper.map(vendedor,VendedorDto.class)).collect(Collectors.toList());

	}

	private Vendedor getVendedorEntity(Long id) throws Exception {
		return vendedorRepository.findById(id).orElseThrow(()-> new Exception("Not Found"));
	}
}