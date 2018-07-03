package gov.hhs.usas.rest.report.service;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportService {
	private static final Logger log = LoggerFactory.getLogger(ReportService.class);
	
	static class XsiTypeReader extends StreamReaderDelegate {
		public XsiTypeReader(XMLStreamReader reader) {
			super(reader);
		}
		@Override
		public String getNamespaceURI() {
			return "";
		}
	}

}
