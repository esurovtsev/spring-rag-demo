package com.grabduck.springrag.domain.port;

import java.util.List;
import com.grabduck.springrag.domain.model.Document;
import com.grabduck.springrag.domain.model.Query;
import com.grabduck.springrag.domain.model.Response;

/**
 * Port interface for chat/LLM operations.
 */
public interface ChatPort {
    Response chat(Query query, List<Document> contextDocuments);
}
