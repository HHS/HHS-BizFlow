package gov.hhs.usas.rest.report.service;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

public class ReportService {
	
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
