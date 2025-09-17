package me.DIO.Ecommerce.service;

import jakarta.transaction.Transactional;
import me.DIO.Ecommerce.dtos.ProductDTO;
import me.DIO.Ecommerce.dtos.UserDTO;
import me.DIO.Ecommerce.model.CarItem;
import me.DIO.Ecommerce.model.Product;
import me.DIO.Ecommerce.repository.ProductRepository;
import me.DIO.Ecommerce.repository.UserRepository;
import me.DIO.Ecommerce.service.exceptions.DataBaseException;
import me.DIO.Ecommerce.service.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductDTO save(ProductDTO dto) {
        Product product = new Product();
        copyDtoToEntity(dto, product);
        Product savedProduct = productRepository.save(product);
        return new ProductDTO(savedProduct);
    }

    @Transactional
    public ProductDTO update(ProductDTO dto) {
        //Verifica se o produto existe antes de altera-lo
        Product entity = productRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFound("Product not found"));

        copyDtoToEntity(dto, entity);
        Product updatedProduct = productRepository.save(entity);

        return new ProductDTO(updatedProduct);
    }

    @Transactional
    public void delete(Long id) {
        if(!productRepository.existsById(id)) {
            throw new ResourceNotFound("Product not found: " + id);
        }
        try{
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }

    public Page<ProductDTO> findAll(Pageable page){
        Page<Product> list = productRepository.findAll(page);
        return list.map(ProductDTO::new);
    }

    @Transactional
    public List<ProductDTO> findByName(String name) {
        List<Product> list = productRepository.findByNameContainingIgnoreCase(name);
        return list.stream().map(ProductDTO::new).toList();
    }

    private void copyDtoToEntity(ProductDTO dto, Product product) {
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
    }
}
