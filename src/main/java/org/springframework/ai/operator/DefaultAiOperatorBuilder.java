package org.springframework.ai.operator;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.memory.Memory;
import org.springframework.ai.vectorstore.VectorStore;

public class DefaultAiOperatorBuilder implements AiOperator.Builder {

	private ChatClient aiClient;

	private PromptTemplate promptTemplate;

	private VectorStore vectorStore;

	private String vectorStoreKey = "documents";

	private Memory memory;

	private String inputParameterName = "input";

	private String historyParameterName = "history";

	private int k = 2;

	public DefaultAiOperatorBuilder() {
	}

	@Override
	public AiOperator.Builder aiClient(ChatClient aiClient) {
		this.aiClient = aiClient;
		return this;
	}

	@Override
	public AiOperator.Builder promptTemplate(String promptTemplate) {
		this.promptTemplate = new PromptTemplate(promptTemplate);
		return this;
	}

	@Override
	public AiOperator.Builder vectorStore(VectorStore vectorStore) {
		this.vectorStore = vectorStore;
		return this;
	}

	@Override
	public AiOperator.Builder vectorStoreKey(String vectorStoreKey) {
		this.vectorStoreKey = vectorStoreKey;
		return this;
	}

	public AiOperator.Builder conversationMemory(Memory memory) {
		this.memory = memory;
		return this;
	}

	public AiOperator.Builder inputParameterName(String inputParameterName) {
		this.inputParameterName = inputParameterName;
		return this;
	}

	public AiOperator.Builder historyParameterName(String historyParameterName) {
		this.historyParameterName = historyParameterName;
		return this;
	}

	public AiOperator.Builder k(int k) {
		this.k = k;
		return this;
	}

	public AiOperator build() {
		DefaultAiOperator aiOperator = new DefaultAiOperator(aiClient, promptTemplate);
		aiOperator.vectorStore(vectorStore);
		aiOperator.vectorStoreKey(vectorStoreKey);
		aiOperator.conversationMemory(memory);
		aiOperator.inputParameterName(inputParameterName);
		aiOperator.historyParameterName(historyParameterName);
		aiOperator.k(k);
		return aiOperator;
	}

}
