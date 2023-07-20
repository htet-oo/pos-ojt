package posojt.web.form;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import posojt.bl.dto.ShopDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopRegister {
	private int id;
	
	@NotBlank(message = "Please Enter Name")
	private String name;
	
	@NotBlank(message = "Please Enter Phone")
	private String phone;
	
	@NotNull(message = "Please Upload Logo")
	private MultipartFile  logo;
	
	@NotNull(message = "Please Upload Cover Photo")
	private MultipartFile  coverPhoto;
	
	@NotBlank(message = "Please Enter Address")
	private String address;
	
	@NotBlank(message = "Please Enter Summary")
	private String summary;
	
	private String email;
	
	public ShopRegister(ShopDTO shopDTO) {
		this.id = shopDTO.getId();
		this.name = shopDTO.getName();
		this.phone = shopDTO.getPhone_number();
		this.logo =  createMultipartFileFromFilename(shopDTO.getLogo());
		this.coverPhoto = createMultipartFileFromFilename(shopDTO.getCover_photo());

		this.address = shopDTO.getAddress();
		this.summary = shopDTO.getSummary();
	}
	
    private MultipartFile createMultipartFileFromFilename(String filename) {
        if (StringUtils.isEmpty(filename)) {
            return null;
        }

        return new MultipartFile() {
            @Override
            public String getName() {
                return filename;
            }

            @Override
            public String getOriginalFilename() {
                return filename;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return new byte[0];
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return new ByteArrayInputStream(new byte[0]);
            }

            @Override
            public void transferTo(File dest) throws IOException, IllegalStateException {
            }
        };
    }
}
